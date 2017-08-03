package com.emusicstore.dao.impl;

import com.emusicstore.dao.CartDao;
import com.emusicstore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by grgbibek22 on 8/2/2017.
 */
@Repository
public class CartDaoImpl implements CartDao{

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart){
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Cannot create a cart. &cart with the given id(%)" + "already" +
                                            "exists.", cart.getCartId()));
        }
        else{
            listOfCarts.put(cart.getCartId(),cart);
        }
        return cart;
    }

    public Cart read(String cartId){
        return listOfCarts.get(cartId);
    }

    public void update(String cartId,Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Cannot update cart. The cart with the given id(%)" + "does not" +
                    "exist.", cartId));
        } else {
            //putting the sessionId/cartid in the listOfCarts so as to notify the cart has been updated
            listOfCarts.put(cartId, cart);
        }
    }

    public void delete(String cartId){
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot delete the cart because the cart with the given id(%)+" +
                    " doesn't exist",cartId));
        }else{
            listOfCarts.remove(cartId);
        }

    }


}
