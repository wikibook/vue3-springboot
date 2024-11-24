import axios from "axios";

// 회원가입
export const join = (args) => {
    return axios.post("/v1/api/account/join", args).catch(e => e.response);
};

// 로그인
export const login = (args) => {
    return axios.post("/v1/api/account/login", args).catch(e => e.response);
};

// 로그인 여부 확인
export const check = () => {
    return axios.get("http://localhost:8080/v1/api/account/check").catch(e => e.response);
};

// 로그아웃
export const logout = () => {
    return axios.post("/v1/api/account/logout").catch(e => e.response);
};