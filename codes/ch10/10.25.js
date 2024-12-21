import axios from "axios"; // ①

// 주문 삽입
export const addOrder = (args) => { // ②
    return axios.post("/v1/api/orders", args).catch(e => e.response);
};

// 주문 목록 조회
export const getOrders = (args) => { // ③
    return axios.get("/v1/api/orders", args).catch(e => e.response);
}

// 주문 상세 조회
export const getOrder = (id) => { // ④
    return axios.get(`/v1/api/orders/${id}`).catch(e => e.response);
};