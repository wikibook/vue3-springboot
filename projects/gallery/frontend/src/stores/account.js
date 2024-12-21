import {defineStore} from 'pinia'

export const useAccountStore = defineStore("account", {
    state: () => ({
        checked: false,
        loggedIn: false,
        accessToken: "",
    }),
    actions: {
        setChecked(val) {
            this.checked = val;
        },
        setLoggedIn(val) {
            this.loggedIn = val;
        },
        setAccessToken(val) {
            this.accessToken = val;
        },
    },
});