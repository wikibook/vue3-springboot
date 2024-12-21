<script setup>
import {reactive} from "vue";
import {join} from "@/services/accountService";
import {useRouter} from "vue-router";

// 반응형 상태
const state = reactive({
  form: {
    name: "",
    loginId: "",
    loginPw: "",
  }
});

// 라우터 객체
const router = useRouter();

// 회원가입 데이터 제출
const submit = async () => {
  if (!state.form.name?.trim()) {
    window.alert("이름을 입력해주세요.");
    document.getElementById("name")?.focus();
    return;
  } else if (!state.form.loginId?.trim()) {
    window.alert("이메일을 입력해주세요.");
    document.getElementById("loginId")?.focus();
    return;
  } else if (!state.form.loginPw?.trim()) {
    window.alert("패스워드를 입력해주세요.");
    document.getElementById("loginPw")?.focus();
    return;
  }

  const res = await join(state.form);

  if (res.status === 200) {
    window.alert("회원가입을 완료했습니다.");
    await router.push("/");
  } else if (res.status === 409) {
    window.alert("이미 사용 중인 이메일입니다. 다른 값을 입력해주세요.");
    document.getElementById("loginId")?.focus();
  }
};
</script>

<template>
  <div class="join">
    <div class="container">
      <form class="py-5 d-flex flex-column gap-3" @submit.prevent="submit">
        <h1 class="h5 mb-3">회원가입</h1>
        <div class="form-floating">
          <input type="text" class="form-control" id="name" placeholder="이름" v-model="state.form.name">
          <label for="name">이름</label>
        </div>
        <div class="form-floating">
          <input type="email" class="form-control" id="loginId" placeholder="이메일" v-model="state.form.loginId">
          <label for="loginId">이메일</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="loginPw" placeholder="패스워드" v-model="state.form.loginPw">
          <label for="loginPw">패스워드</label>
        </div>
        <button type="submit" class="w-100 h6 btn py-3 btn-primary">회원가입</button>
      </form>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.join > .container {
  max-width: 576px;
}
</style>