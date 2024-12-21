<script setup>
import {reactive} from "vue";
import {getOrder} from "@/services/orderService";
import {useRoute} from "vue-router";

// 라우트 객체
const route = useRoute();

// 반응형 상태
const state = reactive({
  order: {
    id: 0,
    name: "",
    address: "",
    payment: "",
    amount: 0,
    created: "",
    items: [],
  }
});

// 커스텀 생성 훅
(async function onCreated() {
  const id = route.params.id;
  const res = await getOrder(id);

  if (res.status === 200) {
    state.order = res.data;
  }
})();
</script>

<template>
  <div class="order-detail py-5">
    <div class="container">
      <div class="row">
        <div class="order col-lg-8">
          <div class="h5 mb-4">
            <b>주문 내용</b>
          </div>
          <table class="table table-bordered">
            <tbody>
            <tr>
              <th>주문 ID</th>
              <td>{{ state.order.id }}</td>
            </tr>
            <tr>
              <th>주문자명</th>
              <td>{{ state.order.name }}</td>
            </tr>
            <tr>
              <th>주소</th>
              <td>{{ state.order.address }}</td>
            </tr>
            <tr>
              <th>결제 금액</th>
              <td>{{ state.order.amount.toLocaleString() }}원</td>
            </tr>
            <tr>
              <th>결제 수단</th>
              <td>{{ state.order.payment === 'card' ? '카드' : '무통장입금(한국은행 123-456789-777)' }}</td>
            </tr>
            <tr>
              <th>결제 일시</th>
              <td>{{ state.order.created.toLocaleString() }}</td>
            </tr>
            </tbody>
          </table>
        </div>
        <div class="items col-lg-4">
          <div class="h5 mb-4">
            <b>주문 상품</b>
          </div>
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>번호</th>
              <th>상품명</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(item, idx) in state.order.items">
              <td>{{ idx + 1 }}</td>
              <td>{{ item.name }}</td>
            </tr>
            </tbody>
            <tfoot>
            </tfoot>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.order-detail {
  > .container {
    table {
      th, td {
        padding: 15px 25px;
      }

      th {
        background: #f7f7f7;
      }
    }
  }
}
</style>