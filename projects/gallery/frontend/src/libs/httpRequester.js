import axios from "axios";
import {useAccountStore} from "@/stores/account";

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
            const config = err.config;

            if (config.retried) { // 재요청 여부
                window.alert("권한이 없습니다.");
                window.location.replace("/");
                return;
            }

            // (쿠키에 있는) 리프레시 토큰으로 액세스 토큰 요청
            const res = await axios.get("/v1/api/account/token");

            // 액세스 토큰
            const accessToken = res.data;

            // 계정 스토어
            const accountStore = useAccountStore();

            // 계정 스토어의 액세스 토큰 변경
            accountStore.setAccessToken(accessToken);

            // 요청 액세스 토큰 교체
            config.headers.authorization = `Bearer ${accountStore.accessToken}`;

            // 중복 재요청 방지를 위한 프로퍼티 추가
            config.retried = true;

            // 재요청
            return instance(config);

        case 500:
            window.alert("오류가 있습니다. 관리자에게 문의해주세요.");
            break;
    }

    return Promise.reject(err);
});

// HTTP 요청 설정 생성
const generateConfig = () => {
    // 계정 스토어
    const accountStore = useAccountStore();

    if (accountStore.accessToken) {
        return {
            headers: {authorization: `Bearer ${accountStore.accessToken}`}
        };
    }

    return {};
};

export default {
    get(url, params) {
        const config = generateConfig();
        config.params = params;
        return instance.get(url, config);
    },
    post(url, params) {
        return instance.post(url, params, generateConfig());
    },
    put(url, params) {
        return instance.put(url, params, generateConfig());
    },
    delete(url) {
        return instance.delete(url, generateConfig());
    },
};