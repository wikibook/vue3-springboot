<script setup>
import {reactive} from "vue";
import {StorageService} from "@/services/StorageService";
import {useRouter} from "vue-router";

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

// 데이터 제출
const submit = () => {
  // 메모 삽입
  storageService.addItem(state.memo);

  // 안내 메시지 출력
  window.alert("저장했습니다.");

  // 메인 화면으로 이동
  router.push({path: "/"});
};
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