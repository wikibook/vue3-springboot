<script setup>
import {reactive} from "vue";
import {StorageService} from "@/services/StorageService";
import {useRoute, useRouter} from "vue-router";

// 스토리지 서비스의 객체(인스턴스) 생성
const storageService = new StorageService("myMemo");

// 라우터 객체
const router = useRouter();

// 반응형 상태
const state = reactive({
  memo: {
    id: undefined,
    title: "",
    content: ""
  }
});

// 라우트 객체
const route = useRoute();

// 데이터 제출
const submit = () => {
  // 라우트 객체 매개변수의 id 값이 있을 때
  if (route.params.id) {
    storageService.setItem(state.memo);
  } else {
    storageService.addItem(state.memo);
  }

  window.alert("저장했습니다.");
  router.push({path: "/"});
};

// 커스텀 생성 훅
(async function onCreated() {
  // 라우트 객체 매개변수의 id 값이 있을 때
  if (route.params.id) {
    const id = Number.parseInt(route.params.id.toString());
    state.memo = storageService.getItem(id);
  }
})();
</script>

<template>
  <form class="detail" @submit.prevent="submit">
    <div class="mb-3">
      <label for="title" class="form-label">제목</label>
      <!-- 제목 출력 -->
      <input type="text" id="title" class="form-control p-3"
             v-model="state.memo.title"/>
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용</label>
      <!-- 내용 입력 -->
      <textarea id="content" class="form-control p-3"
                v-model="state.memo.content"></textarea>
    </div>
    <button type="submit" class="btn btn-primary w-100 py-3">저장</button>
  </form>
</template>