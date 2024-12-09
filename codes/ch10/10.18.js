import axios from "axios"; // ①

// 상품 목록 조회
export const getItems = () => { // ②
    return axios.get("/v1/api/items").catch(e => e.response);
};