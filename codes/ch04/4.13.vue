<script setup>
const message = { name: "Kim", age: 20 };
</script>

<template>
  <div>
    <span>Hello </span>
    <span v-text="message"></span>
  </div>
</template>