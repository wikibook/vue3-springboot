import {defineStore} from 'pinia';

export const useCounterStore = defineStore('counter', { // ①
    state: () => ({ // ②
        count: 0
    }),
    actions: { // ③
        increment() {
            this.count++
        },
    },
    getters: { // ④
        doubleCount: (state) => state.count * 2,
    },
});