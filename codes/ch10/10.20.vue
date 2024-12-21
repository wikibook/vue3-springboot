<script setup>
import {getItems} from "@/services/itemService";
import {reactive} from "vue";
import Card from "@/components/Card.vue";

// 반응형 상태
const state = reactive({ // ①
  items: []
});

// 커스텀 생성 훅
(async function onCreated() { // ②
  const res = await getItems();

  if (res.status === 200) {
    state.items = res.data;
  }
})();
</script>

<template>
  <div class="home">
    <div class="album py-5 bg-light"> <!-- ③ -->
      <div class="container"> <!-- ④ -->
        <div class="row row-cols-1 row-cols-lg-2 row-cols-xl-3 g-3"> <!-- ⑤ -->
          <div class="col" v-for="item in state.items"> <!-- ⑥ -->
            <Card :item="item"/> <!-- ⑦ -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>