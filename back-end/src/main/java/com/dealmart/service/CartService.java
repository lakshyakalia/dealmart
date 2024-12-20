package com.dealmart.service;

import com.dealmart.model.Cart;

import java.util.List;

public interface CartService {

    Cart addCart(Cart cart);

    List<Cart> getAllCarts();

    Cart getCartById(long id);

    Cart updateCart(Cart cart, long id);

    void deleteCart(long id);
}
