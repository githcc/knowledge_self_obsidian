function FindProxyForURL(url, host) {
    // 如果是本地主机，也直接连接
    if (dnsDomainIs(host, "localhost")) {
        return "DIRECT";
    }

    if (isPlainHostName(host) ||
        shExpMatch(host, "*.local") ||
        isInNet(dnsResolve(host), "10.0.0.0", "255.0.0.0") ||
        isInNet(dnsResolve(host), "172.16.0.0", "255.240.0.0") ||
        isInNet(dnsResolve(host), "192.168.0.0", "255.255.0.0")) {
        return "DIRECT";
    }

    // 检查是否为特定域名，如果是，则直接连接
    if (dnsDomainIs(host, "bilibili.com") ||
        dnsDomainIs(host, "biliapi.net") ||
        dnsDomainIs(host, "bilivideo.cn")) {
        return "DIRECT";
    }

    // 对于所有其他网址，使用代理服务器
    return "PROXY 127.0.0.1:7890";
}