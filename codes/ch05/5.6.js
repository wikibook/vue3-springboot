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

    // 신규 항목 삽입
    addItem(item) { // ①
        const storageData = this.#getStorageData();

        // 현재 nextId를 항목의 id에 적용하고 1만큼 증가
        item.id = storageData.nextId++;

        storageData.items.push(item);
        this.#saveStorageData(storageData);
    }

    // 전체 항목 조회
    getItems() { // ②
        return this.#getStorageData().items;
    }

    // 특정 항목 조회
    getItem(id) { // ③
        return this.#getStorageData().items.find(i => i.id === id);
    }

    // 특정 항목 수정
    setItem(item) { // ④
        const storageData = this.#getStorageData();

        for (let i = 0; i < storageData.items.length; i += 1) {
            if (storageData.items[i].id === item.id) {
                storageData.items[i] = item;
                break;
            }
        }

        this.#saveStorageData(storageData);
    }

    // 특정 항목 삭제
    delItem(id) { // ⑤
        const storageData = this.#getStorageData();
        const idx = storageData.items.findIndex(i => i.id === id);

        if (idx > -1) {
            storageData.items.splice(idx, 1)
            this.#saveStorageData(storageData);
        }
    }
}