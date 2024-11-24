<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import {useAccountStore} from "@/stores/account";
import {watch} from "vue";
import {useRoute} from "vue-router";

// 계정 스토어
const accountStore = useAccountStore();

// 라우트 객체
const route = useRoute();

// 로그인 여부 확인
const checkAccount = async () => {
  // 추후 구현
};

// 커스텀 생성 훅
(async function onCreated() {
  await checkAccount();
})();

// 라우트 경로가 바뀔 때마다 로그인 여부를 확인
watch(() => route.path, () => {
  checkAccount();
});
</script>

<template>
  <Header/>
  <main>
    <!-- 라우터 뷰 -->
    <router-view></router-view>
  </main>
  <Footer/>
</template>