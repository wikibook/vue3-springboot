<script setup>
// 커스텀 생성 훅
(async function onCreated() {
  console.log(document.getElementById("message"));
})();
</script>

<template>
  <div id="message">Aloha!</div>
</template>