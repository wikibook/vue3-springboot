<script setup>
let loading = true;
</script>

<template>
  <input type="text" placeholder="아이디" :readonly="loading" />
  <input type="password" placeholder="패스워드" :readonly="loading" />
  <button :disabled="loading">로그인</button>
</template>