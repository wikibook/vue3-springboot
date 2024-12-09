import {defineStore} from 'pinia'

export const useAccountStore = defineStore("account", { // ①
    state: () => ({
        checked: false, // ②
        loggedIn: false, // ③
    }),
    actions: {
        setChecked(val) { // ④
            this.checked = val;
        },
        setLoggedIn(val) { // ⑤
            this.loggedIn = val;
        },
    },
});