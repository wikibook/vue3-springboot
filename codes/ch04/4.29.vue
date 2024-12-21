<script setup>
const pop = (message) => {
  window.alert(message);
}
</script>

<template>
  <button v-on:click="pop('Hello')">Hello</button>
</template>