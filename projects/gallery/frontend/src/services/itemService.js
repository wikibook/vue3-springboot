import httpRequester from "@/libs/httpRequester";

// 상품 목록 조회
export const getItems = () => {
    return httpRequester.get("/v1/api/items").catch(e => e.response);
};