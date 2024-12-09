<script setup>
import Tire from "@/components/Tire.vue";
</script>

<template>
  <div class="front-wheel">
    <span>FRONT WHEEL</span>
    <Tire color="BLUE"/>
  </div>
</template>

<style scoped>
.front-wheel {
  border: 1px solid black;
  border-radius: 50%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 150px;
  height: 150px;
}
</style>