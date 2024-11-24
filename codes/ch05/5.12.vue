<script setup>
import {reactive} from "vue";
import {StorageService} from "@/services/StorageService";

// 스토리지 서비스 생성
const storageService = new StorageService("myMemo");

// 반응형 상태
const state = reactive({
  memos: []
});

// 커스텀 생성 훅
(async function onCreated() {
  state.memos = storageService.getItems();
})();
</script>

<template>
  <div class="memo-list">
    <!-- 메모를 순회하며 출력 -->
    <router-link :to="`/memos/${m.id}`" class="item" v-for="m in state.memos">
      <div class="d-flex pt-3">
        <div class="pb-3 mb-0 w-100">
          <div class="d-flex justify-content-between">
            <!-- 메모 제목 -->
            <b>{{ m.title }}</b>
            <div>
              <span role="button">삭제</span> <!-- 추후 구현 -->
            </div>
          </div>
          <!-- 메모 내용 -->
          <div class="mt-2">{{ m.content }}</div>
        </div>
      </div>
    </router-link>
    <router-link to="/memos/add" class="add btn btn-light">+ 추가하기</router-link>
  </div>
</template>