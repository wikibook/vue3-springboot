import axios from "axios";

// 상품 목록 조회
export const getItems = () => {
    return axios.get("/v1/api/items").catch(e => e.response);
};