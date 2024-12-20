package com.dealmart.service.impl;

import com.dealmart.exception.ResourceNotFoundException;
import com.dealmart.model.Cart;
import com.dealmart.repository.CartRepository;
import com.dealmart.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        super();
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(long id) {
        return cartRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cart", "Id", id));
    }

    @Override
    public Cart updateCart(Cart cart, long id) {
        Cart existingCart = cartRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cart", "Id", id));

        existingCart.setQuantity(cart.getQuantity());
        existingCart.setUser(cart.getUser());
        existingCart.setProduct(cart.getProduct());

        cartRepository.save(existingCart);

        return existingCart;
    }

    @Override
    public void deleteCart(long id) {
        cartRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cart", "Id", id));

        cartRepository.deleteById(id);
    }
}
