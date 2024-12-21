# 특정 자바 버전을 시스템에 인식(패스워드 입력 필요)
sudo ln -sfn /opt/homebrew/opt/openjdk@21 /Library/Java/JavaVirtualMachines/openjdk-21.jdk

# 환경변수 설정
echo 'export JAVA_HOME=/opt/homebrew/opt/openjdk@21' >> ~/.zshrc
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.zshrc

# 환경변수 설정 적용
source ~/.zshrc