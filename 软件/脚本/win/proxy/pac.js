function FindProxyForURL(url, host) {
    // 如果是本地主机，也直接连接
    if (dnsDomainIs(host, "localhost")) {
        return "DIRECT";
    }

    // 对于所有其他网址，使用代理服务器
    return "PROXY 127.0.0.1:7890";
}