/*


*/

#include<iostream>
using namespace std;

int main(){
	int N=0, visited[26], count=0, result;
	char word[100], temp;

	cin >> N;
	for(int i=0; i<N; i++){

		//단어 입력
		cin >> word;

		//방문 여부 초기화
		for(int j=0; j<26; j++)
			visited[j] = 0;
		//cout << "reset for " << i << endl; 

		//단어 확인
		for(int j=0; word[j]!='\0'; j++){
			//cout << "word[" << j << "] = " << word[j] << endl;
			if( (visited[word[j]-'a'] == 1) && (word[j]!=word[j-1]) ){	//방문한 알파벳 and 이전 알파벳과 다르다
				count++;
				break;
			}
			else
				visited[word[j]-'a'] = 1;
		}
	}
	cout << N-count;
}