import axios from "axios";

const instance = axios.create();

// 인터셉터(응답 시)
instance.interceptors.response.use((res) => {
    return res;
}, async (err) => {
    switch (err.response.status) {
        case 400:
            window.alert("잘못된 요청입니다.");
            break;

        case 401:
            window.alert("권한이 없습니다.");
            window.location.replace("/");
            break;

        case 500:
            window.alert("오류가 있습니다. 관리자에게 문의해주세요.");
            break;
    }

    return Promise.reject(err);
});

export default {
    get(url, params) {
        return instance.get(url, {params});
    },
    post(url, params) {
        return instance.post(url, params);
    },
    put(url, params) {
        return instance.put(url, params);
    },
    delete(url) {
        return instance.delete(url);
    }
};