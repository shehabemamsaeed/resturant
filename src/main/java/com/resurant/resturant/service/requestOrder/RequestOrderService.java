package com.resurant.resturant.service.requestOrder;

import com.resurant.resturant.dto.RequestOrderDto;
import com.resurant.resturant.dto.StringModel;
import com.resurant.resturant.model.RequestOrder;

public interface RequestOrderService {
StringModel saveOrder(RequestOrderDto requestOrderDto) throws RuntimeException;
}
