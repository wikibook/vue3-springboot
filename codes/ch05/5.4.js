export class StorageService {
    // 스토리지 이름
    #storageName; // ①

    // 생성자
    constructor(storageName) { // ②
        // 스토리지 이름이 없을 때
        if (!storageName) {
            throw new Error("스토리지 이름을 입력해주세요.");
        }

        this.#storageName = storageName;
    }
}