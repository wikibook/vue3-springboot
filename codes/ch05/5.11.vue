<script setup>
import {reactive} from "vue";
import {StorageService} from "@/services/StorageService";

// 스토리지 서비스 생성
const storageService = new StorageService("myMemo"); // ①

// 반응형 상태
const state = reactive({ // ②
  memos: []
});

// 커스텀 생성 훅
(async function onCreated() { // ③
  state.memos = storageService.getItems();
})();
</script>