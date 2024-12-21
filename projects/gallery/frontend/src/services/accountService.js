import httpRequester from "@/libs/httpRequester";

// 회원가입
export const join = (args) => {
    return httpRequester.post("/v1/api/account/join", args).catch(e => e.response);
};

// 로그인
export const login = (args) => {
    return httpRequester.post("/v1/api/account/login", args).catch(e => e.response);
};

// 로그인 여부 확인
export const check = () => {
    return httpRequester.get("/v1/api/account/check").catch(e => e.response);
};

// 로그아웃
export const logout = () => {
    return httpRequester.post("/v1/api/account/logout").catch(e => e.response);
};