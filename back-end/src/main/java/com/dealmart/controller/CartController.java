package com.dealmart.controller;

import com.dealmart.model.Cart;
import com.dealmart.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        super();
        this.cartService = cartService;
    }

    @PostMapping()
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        return new ResponseEntity<Cart>(cartService.addCart(cart), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") long cartId){
        return new ResponseEntity<Cart>(cartService.getCartById(cartId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") long cartId, @RequestBody Cart cart){
        return new ResponseEntity<Cart>(cartService.updateCart(cart, cartId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") long cartId) {
        cartService.deleteCart(cartId);
        return new ResponseEntity<String>("Cart Deleted Successfully!", HttpStatus.OK);
    }
}
