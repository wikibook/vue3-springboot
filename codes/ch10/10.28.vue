<script setup>
import {reactive} from "vue";
import {getOrders} from "@/services/orderService";

// 반응형 상태
const state = reactive({ // ①
  orders: []
});

// 주문 목록 조회
const load = async () => { // ②
  const res = await getOrders();

  if (res.status === 200) {
    state.orders = res.data;
  }
};

// 커스텀 생성 훅
(async function onCreated() { // ③
  await load();
})();
</script>

<template>
  <div class="orders">
    <div class="container"> <!-- ④ -->
      <table class="table table-bordered my-4"> <!-- ⑤ -->
        <thead>
        <tr>
          <th class="text-center">번호</th>
          <th>주문자명</th>
          <th>결제 수단</th>
          <th>결제 금액</th>
          <th>결제일시</th>
          <th>자세히 보기</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(o, idx) in state.orders">
          <td class="text-center">{{ state.orders.length - idx }}</td>
          <td>{{ o.name }}</td>
          <td>{{ o.payment === 'card' ? '카드' : '무통장입금' }}</td>
          <td>{{ o.amount.toLocaleString() }}원</td>
          <td>{{ o.created.toLocaleString() }}</td>
          <td>
            <router-link :to="`/orders/${o.id}`">자세히 보기</router-link>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>