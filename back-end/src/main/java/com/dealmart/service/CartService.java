package com.dealmart.service;

import com.dealmart.model.Cart;
import com.dealmart.response.CartResponseBody;

import java.util.List;

public interface CartService {

    Cart addCart(Cart cart);

    List<Cart> getAllCarts();

    Cart getCartById(long id);

    List<CartResponseBody> getCartByUserId(long id);

    Cart updateCart(Cart cart, long id);

    void deleteCart(long id);
}
