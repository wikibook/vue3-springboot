<script setup>
import {reactive} from "vue";

const state = reactive({
  pushUp: 0, // 팔 굽혀 펴기 개수
  sitUp: 0, // 윗몸 일으키기 개수
});

// 팔 굽혀 펴기 개수 증가
const increasePushUp = () => {
  state.pushUp++;
  console.log(document.getElementById("pushUp").innerText);
};

// 윗몸 일으키기 개수 증가
const increaseSitUp = () => {
  state.sitUp++;
  console.log(`sitUp: ${state.sitUp}`);
};
</script>

<template>
  <div>
    <h1>체력 검사</h1>
    <br/>
    <hr/>
    <ul>
      <li id="pushUp">팔 굽혀 펴기: {{ state.pushUp }}</li>
      <li id="sitUp">윗몸 일으키기: {{ state.sitUp }}</li>
    </ul>
    <hr/>
    <br/>
    <button @click="increasePushUp()">팔 굽혀 펴기 증가</button>
    <button @click="increaseSitUp()">윗몸 일으키기 증가</button>
  </div>
</template>