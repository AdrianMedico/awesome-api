package com.company.api.checkout.awesomeapi.service;

import static com.company.api.checkout.awesomeapi.data.dto.WatchModels.*;
import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

import com.company.api.checkout.awesomeapi.data.dto.Watch;

import com.company.api.checkout.awesomeapi.data.dto.WatchModels;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CheckoutServiceImpl implements CheckoutService<List<Watch>, String> {

  @Override
  public String totalPrice(List<Watch> watches) {
    Objects.nonNull(watches);
    Map<Watch, Long> groupedWatchesByQuantity = getWatchesGroupedById(watches);

    Long price = sumPrices(groupedWatchesByQuantity);

    return marshallingToJson(price);
  }

  public Map<Watch, Long> getWatchesGroupedById(List<Watch> watches) {
    return handleWatchList(watches).stream()
        .filter(Objects::nonNull)
        .filter(watch -> !watch.getId().isEmpty())
        .collect(groupingBy(identity(), counting()));
  }

  private List<Watch> handleWatchList(List<Watch> watches) {
    return Optional.ofNullable(watches)
        .orElseThrow(() -> new IllegalArgumentException("Watches list couldn't be null"));
  }

  private Long sumPrices(Map<Watch, Long> groupedWatchesByQuantity) {
    return groupedWatchesByQuantity.entrySet().stream()
        .mapToLong(this::selectModel).sum();
  }

  private Long selectModel(Entry<Watch, Long> entry) {
    Long result = 0l;
    if (ROLEX.getId().equals(entry.getKey().getId())) {
      result = sumWatches(ROLEX, entry.getValue());
    } else if (MICHAEL_KORS.getId().equals(entry.getKey().getId())) {
      result = sumWatches(MICHAEL_KORS, entry.getValue());
    } else if (SWATCH.getId().equals(entry.getKey().getId())) {
      result = sumWatches(SWATCH, entry.getValue());
    } else if (CASIO.getId().equals(entry.getKey().getId())) {
      result = sumWatches(CASIO, entry.getValue());
    }
    return result;
  }

  private Long sumWatches(WatchModels model, Long count) {
    long howManyHasDiscount = count / model.getWatchesUntilDiscount();
    long howManyWithoutDiscount = count % model.getWatchesUntilDiscount();

    return (howManyHasDiscount * model.getPromoPrice()) + (howManyWithoutDiscount * model
        .getPrice());
  }

  private String marshallingToJson(Long price) {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.createObjectNode().put("price", price).toString();
  }

}
