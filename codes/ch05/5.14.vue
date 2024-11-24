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