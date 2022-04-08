int first = 0, last = v2.size() - 1, mid;

while (first <= last) {
  mid = (first + last) / 2;
  cout << "v2[mid].first : " << v2[mid].first << endl;
  if (p1.first == v2[mid].first) {
    cout << "Target found : " << p1.first << endl;
    pair<int, int> temp;
    temp.second = p1.second + v2[mid].second;
    cout << temp.second << endl;
    if (temp.second == 0) {
      temp.first = 0;
      temp.second = 0;
      return temp;
    } else {
      temp.first = p1.first;
      return temp;
    }
  } else {
    if (p1.first < v2[mid].first)
      last = mid - 1;
    else
      first = mid + 1;
  }
}
return p1;
