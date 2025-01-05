package com.resurant.resturant.service.requestOrder.impl;

import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.dto.ProductDto;
import com.resurant.resturant.dto.RequestOrderDto;
import com.resurant.resturant.dto.StringModel;
import com.resurant.resturant.mapper.RequestOrderMapper;
import com.resurant.resturant.model.Client;
import com.resurant.resturant.model.Product;
import com.resurant.resturant.model.RequestOrder;
import com.resurant.resturant.repo.OrderRepo;
import com.resurant.resturant.service.client.ClientService;
import com.resurant.resturant.service.product.ProductService;
import com.resurant.resturant.service.requestOrder.RequestOrderService;
import com.resurant.resturant.utils.ExtractCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RequestOrderServiceImpl implements RequestOrderService {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ClientService clientService;

    @Override
    public StringModel saveOrder(RequestOrderDto requestOrderDto) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                throw new RuntimeException("error.auth");
            }
            ClientDto clientDto = (ClientDto) authentication.getPrincipal();
            Client client = clientService.getClientById(clientDto.getId());
            if (client == null) {
                throw new RuntimeException("error.auth");
            }
            String code = ExtractCode.getCode();
            requestOrderDto.setCode(code);
            RequestOrder requestOrder = RequestOrderMapper.mapper.convertRequestOrderDtoToRequestOrder(requestOrderDto);
            requestOrder.setClient(client);

            List<Product> productList = productService.getProductsByIds(requestOrderDto.getProductId());
            if (productList == null || productList.isEmpty()) {
                throw new RuntimeException("error.data");
            }
            requestOrder.setProduct(productList);
            orderRepo.save(requestOrder);
            StringModel model = new StringModel(requestOrderDto.getCode());
            return model;

        } catch (Exception e) {
            throw new RuntimeException("error.catch", e);
        }
    }
}
