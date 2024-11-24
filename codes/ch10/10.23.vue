<script setup>
import {getItems, removeItem} from "@/services/cartService"
import {reactive} from "vue";

// 반응형 상태
const state = reactive({
  items: []
});

// 장바구니 상품 조회
const load = async ()=>{
  const res = await getItems();

  if (res.status === 200) {
    state.items = res.data;
  }
}

// 장바구니 상품 삭제
const remove = async (itemId) => {
  const res = await removeItem(itemId);

  if (res.status === 200) {
    window.alert("선택하신 장바구니의 상품을 삭제했습니다.");
    await load();
  }
}

// 커스텀 생성 훅
(async function onCreated() {
  await load();
})();
</script>

<template>
  <div class="cart">
    <div class="container">
      <template v-if="state.items.length">
        <ul class="items">
          <li v-for="i in state.items">
            <img :alt="`상품 사진(${i.name})`" :src="i.imgPath"/>
            <b class="name">{{ i.name }}</b>
            <span class="price">
            {{ (i.price - i.price * i.discountPer / 100).toLocaleString() }}원
          </span>
            <span class="remove float-end" @click="remove(i.id)" title="삭제">&times;</span>
          </li>
        </ul>
        <div class="act">
          <router-link to="/order" class="btn btn-primary">주문하기</router-link>
        </div>
      </template>
      <div class="text-center py-5" v-else>장바구니가 비어있습니다.</div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.cart {
  .items {
    list-style: none;
    margin: 0;
    padding: 0;

    li {
      border: 1px solid #eee;
      margin-top: 25px;
      margin-bottom: 25px;
    }

    img {
      width: 150px;
      height: 150px;
    }

    .name {
      margin-left: 25px;
    }

    .price {
      margin-left: 25px;
    }

    .remove {
      cursor: pointer;
      font-size: 30px;
      padding: 5px 15px;
    }
  }

  .act .btn {
    width: 300px;
    display: block;
    margin: 0 auto;
    padding: 30px 50px;
    font-size: 20px;
  }
}
</style>