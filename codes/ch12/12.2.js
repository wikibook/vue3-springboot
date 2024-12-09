import fs from 'fs';
import mv from 'mv';

// 원본 디렉터리 위치
const srcDirPath = "dist";

// 대상 디렉터리 위치
const dstDirPath = "../src/main/resources/static";

// 대상 디렉터리 삭제
fs.rmSync(dstDirPath, {recursive: true, force: true});

// 이동 작업 수행
mv(srcDirPath, dstDirPath, {mkdirp: true}, function (err) {
    console.log(err || 'complete!');
});