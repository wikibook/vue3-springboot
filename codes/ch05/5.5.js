export class StorageService {
    // 스토리지 이름
    #storageName;

    // 생성자
    constructor(storageName) {
        // 스토리지 이름이 없을 때
        if (!storageName) {
            throw new Error("스토리지 이름을 입력해주세요.");
        }

        this.#storageName = storageName;
    }

    // 스토리지 데이터 조회
    #getStorageData() {
        // 스토리지 이름을 키로 사용해 데이터를 조회
        const json = localStorage.getItem(this.#storageName);

        // JSON 데이터가 있으면 파싱해서 리턴
        if (json) {
            return JSON.parse(json);
        }

        return {
            items: [],
            nextId: 1
        }
    }

    // 스토리지 데이터 저장
    #saveStorageData(obj) {
        const json = JSON.stringify(obj); // JSON 문자열로 변환
        localStorage.setItem(this.#storageName, json);
    }
}