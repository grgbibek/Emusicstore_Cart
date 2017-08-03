package com.emusicstore.controller;

import com.emusicstore.dao.CartDao;
import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by grgbibek22 on 8/2/2017.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    //here the @ResponseBody is used for binding the object in json format
    @RequestMapping(value="/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId")String cartId){

        return cartDao.read(cartId);
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable (value="cartId") String cartId, @RequestBody Cart cart){
        cartDao.update(cartId,cart);

    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable (value="cartId") String cartId){
        cartDao.delete(cartId);

    }

    @RequestMapping(value="/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable (value="productId") String productId, HttpServletRequest request){
        String sessionId = request.getSession(true).getId();
        //reading to check if the cart contains the cartId/sessionId or not
        Cart cart = cartDao.read(sessionId);

        if(cart==null){
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException(new Exception());

        }

        cart.addCartItem(new CartItem(product));

        //putting the sessionId/cartid in the listOfCarts so as to notify the cartItems in the cart has been updated
        cartDao.update(sessionId,cart);

    }

    @RequestMapping(value="/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable (value="productId") String productId, HttpServletRequest request){
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);

        if(cart==null){
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException(new Exception());

        }

        cart.removeCartItem(new CartItem(product));

        cartDao.update(sessionId,cart);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal Request, please verify your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    public void handleClientError(Exception e){}

}
