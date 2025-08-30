#include <cassert>
#include <iostream>
using namespace std;

int n3(const std::vector<int>& arr) {
  int best = 0;
  int n = arr.size();
  for (int a = 0; a < n; a++) {
    for (int b = a; b < n; b++) {
      int sum = 0;
      for (int k = a; k <= b; k++) {
        sum += arr[k];
      }
      best = max(best, sum);
    }
  }
  return best;
}

int n2(const std::vector<int>& arr) {
  int best = 0;
  int n = arr.size();
  for (int a = 0; a < n; a++) {
    int sum = 0;
    for (int b = a; b < n; b++) {
      sum += arr[b];
      best = max(best, sum);
    }
  }
  return best;
}

int n1(const std::vector<int>& arr) {
  int best = 0;
  int sum = 0;
  for (int i = 0; i < int(arr.size()); i++) {
    sum += arr[i];
    sum = max(sum, arr[i]);
    best = max(sum, best);
  }
  return best;
}

vector<int> sampleData1 = {-1, 2, 4, -3, 5, 2, -5, 2};

int main() {
  assert(10 == n3(sampleData1));
  assert(10 == n2(sampleData1));
  assert(10 == n1(sampleData1));
  return 0;
}


