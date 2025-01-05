package com.resurant.resturant.controller.requestOrder;

import com.resurant.resturant.dto.RequestOrderDto;
import com.resurant.resturant.dto.StringModel;
import com.resurant.resturant.service.requestOrder.RequestOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/request_order")
public class RequestOrderController {
@Autowired
private RequestOrderService requestOrderService;

@PostMapping("save_order")
    public ResponseEntity<StringModel> saveOrder( @RequestBody RequestOrderDto requestOrderDto){
 StringModel model =  requestOrderService.saveOrder(requestOrderDto);
    return ResponseEntity.created(URI.create("/request_order/save_order")).body(model);
}

}
