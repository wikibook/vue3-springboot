package kr.co.wikibook.gallery.cart.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.wikibook.gallery.cart.dto.CartRequest;
import kr.co.wikibook.gallery.cart.dto.CartRead;
import kr.co.wikibook.gallery.cart.service.CartService;
import kr.co.wikibook.gallery.item.dto.ItemRead;
import kr.co.wikibook.gallery.item.service.ItemService;
import kr.co.wikibook.gallery.account.helper.AccountHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ItemService itemService;
    private final AccountHelper accountHelper;

    @GetMapping("/api/cart/items")
    public ResponseEntity<?> readAll(HttpServletRequest req) {
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(req);

        // 장바구니 목록 조회
        List<CartRead> carts = cartService.findAll(memberId);

        // 장바구니 안에 있는 상품 아이디로 상품을 조회
        List<Integer> itemIds = carts.stream().map(CartRead::getItemId).toList();
        List<ItemRead> items = itemService.findAll(itemIds);

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/api/carts")
    public ResponseEntity<?> push(HttpServletRequest req, @RequestBody CartRequest cartReq) {
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(req);

        // 장바구니 데이터 조회(특정 상품)
        CartRead cart = cartService.find(memberId, cartReq.getItemId());

        // 장바구니 데이터가 없다면
        if (cart == null) {
            cartService.save(cartReq.toEntity(memberId));
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/cart/items/{itemId}")
    public ResponseEntity<?> remove(HttpServletRequest req, @PathVariable("itemId") Integer itemId) {
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(req);

        cartService.remove(memberId, itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}