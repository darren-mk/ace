#[cfg(test)]
mod learn_async {
    #[tokio::test]
    async fn basics() {
        async fn page_title(url: &str) -> Option<String> {
            let resp = trpl::get(url).await;
            let txt = resp.text().await;
            trpl::Html::parse(&txt)
                .select_first("title")
                .map(|title| title.inner_html())}
        let sample_url = "https://www.york.ac.uk/teaching/cws/wws/webpage1.html";
        let result = page_title(sample_url).await;
        assert_eq!(Some("Just a moment...".to_string()), result); } }
