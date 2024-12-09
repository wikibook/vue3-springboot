<script setup>
import {computed, reactive} from "vue";
import {addOrder} from "@/services/orderService";
import {useRouter} from "vue-router";
import {getItems} from "@/services/cartService";

// 라우터 객체
const router = useRouter();

// 반응형 상태
const state = reactive({
  items: [],
  form: {
    name: "",
    address: "",
    payment: "card",
    cardNumber: "",
  }
});

// 최종 결제 금액
const computedTotalPrice = computed(() => {
  let result = 0;

  state.items.forEach((i) => {
    result += i.price - i.price * i.discountPer / 100;
  });

  return result;
});

// 주문 데이터 제출
const submit = async () => {
  if (!state.form.name?.trim()) {
    window.alert("이름을 입력해주세요.");
    document.getElementById("name")?.focus();
    return;
  } else if (!state.form.address?.trim()) {
    window.alert("주소를 입력해주세요.");
    document.getElementById("address")?.focus();
    return;
  } else if (state.form.payment === 'card') {
    if (!state.form.cardNumber?.trim()) {
      window.alert("카드 번호를 입력해주세요.");
      document.getElementById("cardNum")?.focus();
      return;
    } else if (state.form.cardNumber.length > 16 || parseInt(state.form.cardNumber).toString() !== state.form.cardNumber) {
      window.alert("카드 번호는 16자 이하의 숫자로만 입력해주세요.");
      document.getElementById("cardNum")?.focus();
      return;
    }
  }

  if (state.form.payment !== "card") { // 결제 수단이 카드가 아니면
    state.form.cardNumber = "";
  }

  state.form.itemIds = state.items.map(i => i.id);
  const res = await addOrder(state.form);

  if (res.status === 200) {
    const messages = ["주문이 완료되었습니다."];

    if (state.form.payment === "bank") {
      const price = computedTotalPrice.value.toLocaleString();
      messages.push(`한국은행 123-456789-777 계좌로 ${price}원을 입금해주시기 바랍니다.`);
    }

    window.alert(messages.join("\n"));
    await router.push("/");
  }
};

// 커스텀 생성 훅
(async function onCreated() {
  const res = await getItems();

  if (res.status === 200) {
    state.items = res.data;
  }
})();
</script>

<template>
  <form class="order-form" @submit.prevent="submit">
    <div class="container">
      <div class="py-5 text-center">
        <div class="h4">
          <b>주문하기</b>
        </div>
        <p class="h6 font-lg mt-3">주문 내역을 확인하시고 주문하기 버튼을 클릭해주세요</p>
      </div>
      <div class="row g-5">
        <div class="col-md-5 col-lg-4 order-md-last">
          <div class="mb-3">
            <span class="h5 mb-3 align-middle me-2">
              <b>구입 목록</b>
            </span>
            <span class="badge bg-primary rounded-pill align-middle">{{ state.items.length }}</span>
          </div>
          <ul class="items list-group mb-3">
            <li class="p-3 list-group-item d-flex justify-content-between" v-for="i in state.items">
              <div>
                <h6 class="my-0">{{ i.name }}</h6>
              </div>
              <span class="text-muted">
                {{ (i.price - i.price * i.discountPer / 100).toLocaleString() }}원
              </span>
            </li>
          </ul>
          <div class="border p-4 bg-light h5 rounded text-center total-price">
            <span>합계 </span>
            <b>{{ computedTotalPrice.toLocaleString() }}원</b>
          </div>
          <button type="submit"
                  class="w-100 btn btn-primary py-4 mt-4">결제하기</button>
        </div>
        <div class="col-md-7 col-lg-8">
          <div class="h5 mb-3">
            <b>주문자 정보</b>
          </div>
          <div class="row g-3">
            <div class="col-12">
              <label for="name" class="form-label">이름</label>
              <input type="text" class="form-control p-3" id="name" v-model="state.form.name"/>
            </div>
            <div class="col-12 pt-1">
              <label for="address" class="form-label">주소</label>
              <input type="text" class="form-control p-3" id="address" v-model="state.form.address"/>
            </div>
          </div>
          <div class="h5 mt-5 mb-3">
            <b>결제 수단</b>
          </div>
          <div class="my-3">
            <div class="form-check">
              <input id="card" name="paymentMethod" type="radio" class="form-check-input" value="card" v-model="state.form.payment">
              <label class="form-check-label" for="card">신용카드</label>
            </div>
            <div class="form-check">
              <input id="bank" name="paymentMethod" type="radio" class="form-check-input" value="bank" v-model="state.form.payment">
              <label class="form-check-label" for="bank">무통장입금</label>
            </div>
          </div>
          <div class="pt-1" v-if="state.form.payment === 'card'">
            <label for="cardNum" class="form-label">카드 번호</label>
            <input type="text" class="form-control p-3" id="cardNum" v-model="state.form.cardNumber">
          </div>
        </div>
      </div>
    </div>
  </form>
</template>