<script setup>
// 로그아웃
const logoutAccount = async () => { // ①
  window.alert("준비 중입니다.");
};
</script>

<template>
  <header>
    <div class="navbar navbar-dark bg-dark text-white shadow-sm">
      <div class="container"> <!-- ② -->
        <router-link to="/" class="navbar-brand"> <!-- ③ -->
          <strong>Gallery</strong>
        </router-link>
        <div class="menus d-flex gap-3"> <!-- ④ -->
          <template v-if="true"> <!-- ⑤ -->
            <router-link to="/login">로그인</router-link>
            <router-link to="/join">회원가입</router-link>
          </template>
          <template v-else>
            <a @click="logoutAccount()">로그아웃</a> <!-- ⑥ -->
            <router-link to="/orders">주문 내역</router-link>
            <router-link to="/cart">장바구니</router-link>
          </template>
        </div>
      </div>
    </div>
  </header>
</template>

<style lang="scss">
header {
  .menus {
    a { // ⑦
      cursor: pointer;
      color: #fff;
      text-decoration: none;
    }
  }
}
</style>