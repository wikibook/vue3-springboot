<script setup>
import {reactive} from "vue";
import Greeting from "@/components/Greeting.vue";

// 반응형 상태
const state = reactive({
  visible: true
});
</script>

<template>
  <Greeting v-if="state.visible"/>
  <button @click="state.visible = false">hide</button>
</template>